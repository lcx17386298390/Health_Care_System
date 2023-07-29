import request from '@/utils/request'

// 查询医生处方列表
export function listPrescription(query) {
  return request({
    url: 'http://localhost:8002/prescription/prescription/list',
    method: 'get',
    params: query
  })
}

// 查询医生处方详细
export function getPrescription(id) {
  return request({
    url: 'http://localhost:8002/prescription/prescription/' + id,
    method: 'get'
  })
}

// 新增医生处方
export function addPrescription(data) {
  return request({
    url: 'http://localhost:8002/prescription/prescription',
    method: 'post',
    data: data
  })
}

// 修改医生处方
export function updatePrescription(data) {
  return request({
    url: 'http://localhost:8002/prescription/prescription',
    method: 'put',
    data: data
  })
}

// 删除医生处方
export function delPrescription(id) {
  return request({
    url: 'http://localhost:8002/prescription/prescription/' + id,
    method: 'delete'
  })
}
