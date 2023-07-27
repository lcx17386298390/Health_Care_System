<template>
  <div class="container-fluid px-4">
    <h1 class="mt-2">订单处理</h1>
    <ol class="breadcrumb">
      <li class="breadcrumb-item">
        <router-link to="/doc/order">订单</router-link>
      </li>
      <li class="breadcrumb-item active">表格</li>
    </ol>
    <div class="card mb-4">
      <div class="card-header">预约订单列表</div>
      <div class="card-body">
        <div class="datatable-wrapper d-flex flex-column">
          <div class="datatable-top">
            <div class="d-flex justify-content-between">
              <div class="datatable-dropdown">
                <label>
                  <select class="datatable-selector">
                    <option value="5">5</option>
                    <option value="10" selected="">10</option>
                    <option value="15">15</option>
                  </select>
                  折叠条数显示
                </label>
              </div>
              <div class="datatable-search">
                <input
                  class="datatable-input"
                  placeholder="Search..."
                  type="search"
                  title="Search within table"
                  aria-controls="datatablesSimple"
                />
              </div>
            </div>
          </div>
          <div class="datatable-container">
            <table
              id="datatablesSimple"
              class="table table-bordered table-striped"
            >
              <thead>
                <tr>
                  <th>预约日期</th>
                  <th>患者名字</th>
                  <th>预约科室</th>
                  <th>预约状态</th>
                </tr>
              </thead>
              <tbody>
                <tr v-for="(order, index) in paginatedOrders" :key="index">
                  <td>{{ order.appointmentDate }}</td>
                  <td>{{ order.patientName }}</td>
                  <td>{{ order.appointmentDepartment }}</td>
                  <td>{{ order.appointmentStatus }}</td>
                </tr>
              </tbody>
            </table>
          </div>
        </div>
        <Pagination
          v-if="orders.length > perPage"
          :perPage="perPage"
          :total="orders.length"
          @input="setCurrentPage"
        />
        <div class="datatable-bottom">
          <div class="datatable-info">Showing 1 to 10 of 57 entries</div>
          <nav class="datatable-pagination">
            <ul class="datatable-pagination-list">
              <li
                class="datatable-pagination-list-item datatable-hidden datatable-disabled"
              >
                <a data-page="1" class="datatable-pagination-list-item-link"
                  >‹</a
                >
              </li>
              <li class="datatable-pagination-list-item datatable-active">
                <a data-page="1" class="datatable-pagination-list-item-link"
                  >1</a
                >
              </li>
              <li class="datatable-pagination-list-item">
                <a data-page="2" class="datatable-pagination-list-item-link"
                  >2</a
                >
              </li>
              <li class="datatable-pagination-list-item">
                <a data-page="3" class="datatable-pagination-list-item-link"
                  >3</a
                >
              </li>
              <li class="datatable-pagination-list-item">
                <a data-page="4" class="datatable-pagination-list-item-link"
                  >4</a
                >
              </li>
              <li class="datatable-pagination-list-item">
                <a data-page="5" class="datatable-pagination-list-item-link"
                  >5</a
                >
              </li>
              <li class="datatable-pagination-list-item">
                <a data-page="6" class="datatable-pagination-list-item-link"
                  >6</a
                >
              </li>
              <li class="datatable-pagination-list-item">
                <a data-page="2" class="datatable-pagination-list-item-link"
                  >›</a
                >
              </li>
            </ul>
          </nav>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import Pagination from 'vue-pagination-2'
export default {
  components: {
    Pagination,
  },
  data() {
    return {
      orders: [
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
        {
          appointmentDate: "Tiger Nixon",
          patientName: "System Architect",
          appointmentDepartment: "Edinburgh",
          appointmentStatus: 61,
        },
      ],
      perPage: 10,
      currentPage: 1,
    };
  },
  computed: {
    paginatedOrders() {
      const start = (this.currentPage - 1) * this.perPage;
      const end = start + this.perPage;
      return this.orders.slice(start, end);
    },
  },
  methods: {
    setCurrentPage(page) {
      this.currentPage = page;
    },
  },
};
</script>

<style scoped>
.datatable-top > nav:last-child,
.datatable-top > div:last-child,
.datatable-bottom > nav:last-child,
.datatable-bottom > div:last-child {
  float: right;
}
.datatable-pagination li.datatable-hidden {
  visibility: visible;
}
.datatable-pagination li {
  list-style: none;
  float: left;
}
.page-item:first-child .page-link,
.page-item:first-child .datatable-pagination a,
.datatable-pagination .page-item:first-child a,
.datatable-pagination li:first-child .page-link,
.datatable-pagination li:first-child a {
  border-top-left-radius: var(--bs-pagination-border-radius);
  border-bottom-left-radius: var(--bs-pagination-border-radius);
}
.datatable-pagination .datatable-disabled a,
.datatable-pagination .datatable-disabled a:focus,
.datatable-pagination .datatable-disabled a:hover {
  cursor: not-allowed;
  opacity: 0.4;
}
.datatable-pagination .datatable-disabled a,
.datatable-pagination .datatable-disabled a:focus,
.datatable-pagination .datatable-disabled a:hover,
.datatable-pagination .datatable-ellipsis a {
  pointer-events: none;
  cursor: default;
}
.page-link,
.datatable-pagination a {
  position: relative;
  display: block;
  padding: var(--bs-pagination-padding-y) var(--bs-pagination-padding-x);
  font-size: var(--bs-pagination-font-size);
  color: var(--bs-pagination-color);
  text-decoration: none;
  background-color: var(--bs-pagination-bg);
  border: var(--bs-pagination-border-width) solid
    var(--bs-pagination-border-color);
  transition: color 0.15s ease-in-out, background-color 0.15s ease-in-out,
    border-color 0.15s ease-in-out, box-shadow 0.15s ease-in-out;
}
.datatable-pagination a {
  border: 1px solid transparent;
  float: left;
  margin-left: 2px;
  padding: 6px 12px;
  position: relative;
  text-decoration: none;
  color: #333;
  cursor: pointer;
}
a {
  color: var(--bs-link-color);
  text-decoration: underline;
}
.pagination,
.datatable-pagination ul {
  --bs-pagination-padding-x: 0.75rem;
  --bs-pagination-padding-y: 0.375rem;
  --bs-pagination-font-size: 1rem;
  --bs-pagination-color: var(--bs-link-color);
  --bs-pagination-bg: #fff;
  --bs-pagination-border-width: 1px;
  --bs-pagination-border-color: #dee2e6;
  --bs-pagination-border-radius: 0.375rem;
  --bs-pagination-hover-color: var(--bs-link-hover-color);
  --bs-pagination-hover-bg: #e9ecef;
  --bs-pagination-hover-border-color: #dee2e6;
  --bs-pagination-focus-color: var(--bs-link-hover-color);
  --bs-pagination-focus-bg: #e9ecef;
  --bs-pagination-focus-box-shadow: 0 0 0 0.25rem rgba(13, 110, 253, 0.25);
  --bs-pagination-active-color: #fff;
  --bs-pagination-active-bg: #0d6efd;
  --bs-pagination-active-border-color: #0d6efd;
  --bs-pagination-disabled-color: #6c757d;
  --bs-pagination-disabled-bg: #fff;
  --bs-pagination-disabled-border-color: #dee2e6;
  display: flex;
  padding-left: 0;
  list-style: none;
}
.datatable-pagination ul {
  margin: 0;
  padding-left: 0;
}
.datatable-selector {
  padding: 0.375rem 1.75rem 0.375rem 0.75rem;
  height: 2.25rem;
  font-size: 0.875rem;
  border-radius: 0.375rem;
  border: 1px solid #ced4da;
  appearance: none;
  background-repeat: no-repeat;
  background-position: right 0.75rem center;
  background-size: 8px 10px;
}
.datatable-input {
  padding: 0.375rem 1.75rem 0.375rem 0.75rem;
  height: 2.25rem;
  font-size: 0.875rem;
  border-radius: 0.375rem;
  border: 1px solid #ced4da;
}
</style>
