import request from '@/utils/request'

// 查询prescription列表
export function listPrescription(query) {
  return request({
    url: 'http://localhost:8002/prescription/prescription/list',
    method: 'get',
    params: query
  })
}

// 查询prescription详细
export function getPrescription(id) {
  return request({
    url: 'http://localhost:8002/prescription/prescription/' + id,
    method: 'get'
  })
}

// 新增prescription
export function addPrescription(data) {
  return request({
    url: 'http://localhost:8002/prescription/prescription',
    method: 'post',
    data: data
  })
}

// 修改prescription
export function updatePrescription(data) {
  return request({
    url: 'http://localhost:8002/prescription/prescription',
    method: 'put',
    data: data
  })
}

// 删除prescription
export function delPrescription(id) {
  return request({
    url: 'http://localhost:8002/prescription/prescription/' + id,
    method: 'delete'
  })
}
