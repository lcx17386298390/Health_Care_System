<template>
  <form class="d-flex mt-6 me-5" role="search" @submit.prevent="searchItems">
    <div class="input-group">
      <input
        class="form-control"
        type="search"
        placeholder="输入搜索事项..."
        aria-label="Search"
        v-model="searchQuery"
      />
      <button class="btn btn-success" type="submit">Search</button>
    </div>
  </form>
</template>

<script>
export default {
  data() {
    return {
      searchQuery: "",
    };
  },
  methods: {
    searchItems() {
      // Logic for searching the items based on this.searchQuery
      // For simplicity, let's just print the search query to the console
      console.log("Search query:", this.searchQuery);
    },
  },
};
</script>

<style scoped>
.input-group {
  width: 690px;
}
</style>