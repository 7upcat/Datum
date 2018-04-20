import { isUrl } from '../utils/utils';
import menuData from '../../menu';

// let menuData = [
//     {
//       name: '结果页',
//       icon: 'check-circle-o',
//       path: 'result',
//       children: [
//         {
//           name: '成功',
//           path: 'success',
//         },
//         {
//           name: '失败',
//           path: 'fail',
//         },
//       ],
//     },
//     {
//       name: '异常页',
//       icon: 'warning',
//       path: 'exception',
//       children: [
//         {
//           name: '403',
//           path: '403',
//         },
//         {
//           name: '404',
//           path: '404',
//         },
//         {
//           name: '500',
//           path: '500',
//         },
//         {
//           name: '触发异常',
//           path: 'trigger',
//           hideInMenu: true,
//         },
//       ],
//     },
//   ];

function formatter(data, parentPath = '/', parentAuthority) {
  return data.map(item => {
    let { path } = item;
    if (!isUrl(path)) {
      path = parentPath + item.path;
    }
    const result = {
      ...item,
      path,
      authority: item.authority || parentAuthority,
    };
    if (item.children) {
      result.children = formatter(item.children, `${parentPath}${item.path}/`, item.authority);
    }
    return result;
  });
}

export const getMenuData = () => formatter(menuData);
