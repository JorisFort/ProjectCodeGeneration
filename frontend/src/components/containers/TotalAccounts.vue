<template>
  <div class="dashboardSquare">
    <p>Total accounts:</p>
    <p> {{ accounts }}</p>
  </div>
</template>

<script>
export default {
  setup() {
    const accounts = 250000;

    return {
      accounts
    }
  }
}
</script>