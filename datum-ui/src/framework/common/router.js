import { createElement } from 'react';
import dynamic from 'dva/dynamic';
import pathToRegexp from 'path-to-regexp';
import { getMenuData } from './menu';
import routers from '../../router';

const frameRouter = {
  '/': {
    models: ['user', 'login'],
    component: ()=>import('../layouts/BasicLayout'),
    frame: true,    
  },
  '/result/success': {
    component: ()=>import('../routes/Result/Success'),
    frame: true,
  },
  '/result/fail': {
    component: ()=>import('../routes/Result/Error'),
    frame: true,
  },
  '/exception/403': {
    component: ()=>import('../routes/Exception/403'),
    frame: true,
  },
  '/exception/404': {
    component: ()=>import('../routes/Exception/404'),
    frame: true,
  },
  '/exception/500': {
    component: ()=>import('../routes/Exception/500'),
    frame: true,
  },
  '/exception/trigger': {
    models: ['error'],
    component: ()=>import('../routes/Exception/triggerException'),
    frame: true,
  },
  '/user': {
    component: ()=>import('../layouts/UserLayout'),
    frame: true,
  },
  '/user/login': {
    component: ()=>import('../routes/User/Login'),
    frame: true,
  },
  '/user/register': {
    models: ['register'],
    component: ()=>import('../routes/User/Register'),
    frame: true,
  },
  '/user/register-result': {
    component: ()=>import('../routes/User/RegisterResult'),
    frame: true,
  },
};

Object.assign(routers,frameRouter);

let routerDataCache;

const modelNotExisted = (app, model) =>
  // eslint-disable-next-line
  !app._models.some(({ namespace }) => {
    return namespace === model.substring(model.lastIndexOf('/') + 1);
  });

// wrapper of dynamic
const dynamicWrapper = (app, models, component, frame) => {

  // () => require('module')
  // transformed by babel-plugin-dynamic-import-node-sync
  if (component.toString().indexOf('.then(') < 0) {
    models.forEach(model => {
      if (modelNotExisted(app, model)) {
        if(frame){
          // eslint-disable-next-line
          app.model(require(`../models/${model}`).default);
        } else {
          // eslint-disable-next-line
          app.model(require(`../../models/${model}`).default);
        }
        
      }
    });
    return props => {
      if (!routerDataCache) {
        routerDataCache = getRouterData(app);
      }
      return createElement(component().default, {
        ...props,
        routerData: routerDataCache,
      });
    };
  }

  // () => import('module')
  return dynamic({
    app,
    models: () =>{
      // models.filter(model => modelNotExisted(app, model)).map(m => import(frame ?`../models/${m}.js`:`../../models/${m}.js`));
      if(frame) {
        models.filter(model => modelNotExisted(app, model)).map(m => import(`../models/${m}.js`));
      } else {
        models.filter(model => modelNotExisted(app, model)).map(m => import(`../../models/${m}.js`));
      }
    },
    // add routerData prop
    component: () => {
      if (!routerDataCache) {
        routerDataCache = getRouterData(app);
      }
      return component().then(raw => {
        const Component = raw.default || raw;
        return props =>
          createElement(Component, {
            ...props,
            routerData: routerDataCache,
          });
      });
    },
  });
};

function getFlatMenuData(menus) {
  let keys = {};
  menus.forEach(item => {
    if (item.children) {
      keys[item.path] = { ...item };
      keys = { ...keys, ...getFlatMenuData(item.children) };
    } else {
      keys[item.path] = { ...item };
    }
  });
  return keys;
}


export const getRouterData = app => {
  const routerConfig = {};
   
  Object.keys(routers).forEach(key =>{
    const {component, models, frame} = routers[key];
      routerConfig[key]={
        component: dynamicWrapper(app, models||[], component, frame),
      }
  });

  // Get name from ./menu.js or just set it in the router data.
  const menuData = getFlatMenuData(getMenuData());

  // Route configuration data
  // eg. {name,authority ...routerConfig }
  const routerData = {};
  // The route matches the menu
  Object.keys(routerConfig).forEach(path => {
    // Regular match item name
    // eg.  router /user/:id === /user/chen
    const pathRegexp = pathToRegexp(path);
    const menuKey = Object.keys(menuData).find(key => pathRegexp.test(`${key}`));
    let menuItem = {};
    // If menuKey is not empty
    if (menuKey) {
      menuItem = menuData[menuKey];
    }
    let router = routerConfig[path];
    // If you need to configure complex parameter routing,
    // https://github.com/ant-design/ant-design-pro-site/blob/master/docs/router-and-nav.md#%E5%B8%A6%E5%8F%82%E6%95%B0%E7%9A%84%E8%B7%AF%E7%94%B1%E8%8F%9C%E5%8D%95
    // eg . /list/:type/user/info/:id
    router = {
      ...router,
      name: router.name || menuItem.name,
      authority: router.authority || menuItem.authority,
      hideInBreadcrumb: router.hideInBreadcrumb || menuItem.hideInBreadcrumb,
    };
    routerData[path] = router;
  });
  return routerData;
};
