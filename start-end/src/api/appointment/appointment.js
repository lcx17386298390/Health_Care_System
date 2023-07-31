import request from '@/utils/request'

// 查询患者预约列表
export function listAppointment(query) {
  return request({
    url: 'http://localhost:8002/appointment/appointment/list',
    method: 'get',
    params: query
  })
}

// 查询患者预约详细
export function getAppointment(id) {
  return request({
    url: 'http://localhost:8002/appointment/appointment/' + id,
    method: 'get'
  })
}

// 新增患者预约
export function addAppointment(data) {
  return request({
    url: 'http://localhost:8002/appointment/appointment',
    method: 'post',
    data: data
  })
}

// 修改患者预约
export function updateAppointment(data) {
  return request({
    url: 'http://localhost:8002/appointment/appointment',
    method: 'put',
    data: data
  })
}

// 删除患者预约
export function delAppointment(id) {
  return request({
    url: 'http://localhost:8002/appointment/appointment/' + id,
    method: 'delete'
  })
}
