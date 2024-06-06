<template>
    <div class="transfer-between-accounts-page">
      <TransferBetweenAccountsForm />
    </div>
  </template>
  
  <script setup>
  import TransferBetweenAccountsForm from "../TransferBetweenAccountsForm.vue";
  </script>
  
  <style scoped>
  .transfer-between-accounts-page {
    display: flex;
    justify-content: center;
    align-items: center;
    min-height: 100vh;
    padding-top: 70px; /* Ensure it matches the padding-top in #app */
    background-color: #f7f9fc;
  }
  </style>
  