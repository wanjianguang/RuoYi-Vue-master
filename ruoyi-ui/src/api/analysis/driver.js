import request from '@/utils/request'

// 查询司机售后报表列表
export function listDriver(query) {
  return request({
    url: '/analysis/driver/list',
    method: 'get',
    params: query
  })
}

// 查询司机售后报表详细
export function getDriver(id) {
  return request({
    url: '/analysis/driver/' + id,
    method: 'get'
  })
}

// 新增司机售后报表
export function addDriver(data) {
  return request({
    url: '/analysis/driver',
    method: 'post',
    data: data
  })
}

// 修改司机售后报表
export function updateDriver(data) {
  return request({
    url: '/analysis/driver',
    method: 'put',
    data: data
  })
}

// 删除司机售后报表
export function delDriver(id) {
  return request({
    url: '/analysis/driver/' + id,
    method: 'delete'
  })
}

// 导出司机售后报表
export function exportDriver(query) {
  return request({
    url: '/analysis/driver/export',
    method: 'get',
    params: query
  })
}