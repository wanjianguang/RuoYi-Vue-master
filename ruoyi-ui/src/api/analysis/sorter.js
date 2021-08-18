import request from '@/utils/request'

// 查询分拣员售后报列表
export function listSorter(query) {
  return request({
    url: '/analysis/sorter/list',
    method: 'get',
    params: query
  })
}

// 查询分拣员售后报详细
export function getSorter(storeId) {
  return request({
    url: '/analysis/sorter/' + storeId,
    method: 'get'
  })
}

// 新增分拣员售后报
export function addSorter(data) {
  return request({
    url: '/analysis/sorter',
    method: 'post',
    data: data
  })
}

// 修改分拣员售后报
export function updateSorter(data) {
  return request({
    url: '/analysis/sorter',
    method: 'put',
    data: data
  })
}

// 删除分拣员售后报
export function delSorter(storeId) {
  return request({
    url: '/analysis/sorter/' + storeId,
    method: 'delete'
  })
}

// 导出分拣员售后报
export function exportSorter(query) {
  return request({
    url: '/analysis/sorter/export',
    method: 'get',
    params: query
  })
}