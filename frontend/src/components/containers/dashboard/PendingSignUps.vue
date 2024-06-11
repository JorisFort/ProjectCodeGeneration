<template>
  <div class="dashboardSquare">
    <p>Pending sign ups:</p>
    <p> {{ signups }}</p>
  </div>
</template>

<script>
export default {
  setup() {
    const signups = 250;

    return {
      signups
    }
  }
}
</script>