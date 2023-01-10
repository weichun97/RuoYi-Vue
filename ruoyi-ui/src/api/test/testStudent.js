import request from '@/utils/request'

// 查询学生信息列表
export function listTestStudent(query) {
  return request({
    url: '/test/testStudent/query',
    method: 'get',
    params: query
  })
}

// 查询学生信息详细
export function getTestStudent(id) {
  return request({
    url: '/test/testStudent/' + id,
    method: 'get'
  })
}

// 新增学生信息
export function addTestStudent(data) {
  return request({
    url: '/test/testStudent',
    method: 'post',
    data: data
  })
}

// 修改学生信息
export function updateTestStudent(data) {
  return request({
    url: `/test/testStudent/` + data.id,
    method: 'put',
    data: data
  })
}

// 删除学生信息
export function delTestStudent(id) {
  return request({
    url: '/test/testStudent/' + id,
    method: 'delete'
  })
}
