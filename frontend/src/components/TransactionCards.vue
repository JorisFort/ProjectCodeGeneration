<template>
  <div class="transaction-cards">
    <div class="transaction-card" v-for="account in accounts" :key="account.id">
      <span class="account-type">{{ account.type }}</span>
      <h2>{{ account.balance }}</h2>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const accounts = ref([
  { id: 1, type: "Checking", balance: "$44,500.00" },
  { id: 2, type: "Savings", balance: "$44,500.00" },
]);
</script>

<style scoped>
.transaction-cards {
  display: flex;
  justify-content: space-around;
  margin-bottom: 1rem;
}
.transaction-card {
  background: #e0f7fa;
  padding: 1rem;
  border-radius: 10px;
  text-align: center;
  flex: 1;
  margin: 0 0.5rem;
}
.transaction-card:first-child {
  margin-left: 0;
}
.transaction-card:last-child {
  margin-right: 0;
}
.account-type {
  display: block;
  font-weight: bold;
  margin-bottom: 0.5rem;
}
h2 {
  margin: 0;
  font-size: 1.5rem;
}
</style>
