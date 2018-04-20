import request from '../framework/utils/request';

export async function queryConnectors() {
  return request('/api/analysis/connectors');
}
