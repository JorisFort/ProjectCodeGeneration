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
  display: flex; /* flexbox to align sidebar and content */
  height: 100vh; /* full viewport height */
}

.content {
  flex: 1; /* takes up the remaining space */
  overflow-y: auto; /* adds scrolling to the main content only */
}
</style>
