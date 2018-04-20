export default [
    {
      name: '自助分析',
      icon: 'bar-chart',
      path: 'analysis',
      children: [
        {
          name: '数据连接',
          path: 'datasource',
          children: [
            {
              name: '管理连接',
              path: 'connector',
            },
            {
              name: '管理元数据',
              path: 'metadata',
            },
          ],
        },
        {
          name: '数据探索',
          path: 'exploration',
        },
        {
          name: '工作空间',
          path: 'workspace',
        },
      ],
    }, 
  ];