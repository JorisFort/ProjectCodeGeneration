<template>
  <div class="transfer-funds-page">
    <TransferFundsForm />
  </div>
</template>

<script setup>
import TransferFundsForm from "../TransferFundsForm.vue";
</script>

<style scoped>
.transfer-funds-page {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 100vh;
  padding-top: 70px; /* Ensure it matches the padding-top in #app */
  background-color: #f7f9fc;
}
</style>
