<template>
  <div id="app">
    <Sidebar />
    <div class="content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script setup>
import Sidebar from "./components/Sidebar.vue";
</script>

<style scoped>
#app {
  display: flex; /* Flexbox to align sidebar and content */
  height: 100vh; /* Full viewport height */
}

.content {
  flex: 1; /* Takes up the remaining space */
  overflow-y: auto; /* Adds scrolling to the main content only */
}
</style>
