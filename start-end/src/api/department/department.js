import request from '@/utils/request'

// 查询科室信息列表
export function listDepartment(query) {
  return request({
    url: 'http://localhost:8002/department/department/list',
    method: 'get',
    params: query
  })
}

// 查询科室信息详细
export function getDepartment(id) {
  return request({
    url: 'http://localhost:8002/department/department/' + id,
    method: 'get'
  })
}

// 新增科室信息
export function addDepartment(data) {
  return request({
    url: 'http://localhost:8002/department/department',
    method: 'post',
    data: data
  })
}

// 修改科室信息
export function updateDepartment(data) {
  return request({
    url: 'http://localhost:8002/department/department',
    method: 'put',
    data: data
  })
}

// 删除科室信息
export function delDepartment(id) {
  return request({
    url: 'http://localhost:8002/department/department/' + id,
    method: 'delete'
  })
}
