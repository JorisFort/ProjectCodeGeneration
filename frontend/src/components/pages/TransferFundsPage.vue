<template>
  <div class="transfer-funds-page">
    <Sidebar/>
    <!-- Sidebar component added -->
    <div class="form-container">
      <!-- Container for the form to separate it from the sidebar -->
      <TransferFundsForm/>
    </div>
  </div>
</template>

<script setup>
//import Sidebar from "../CustomerNavigation.vue";
import TransferFundsForm from "../containers/dashboard/transaction/TransferFundsForm.vue";
</script>

<style scoped>
.transfer-funds-page {
  display: flex;
  min-height: 100vh;
  background-color: #f7f9fc;
}

.form-container {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-top: 70px;
}
</style>
