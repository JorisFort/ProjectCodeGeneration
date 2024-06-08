<!-- src/components/RecentTransactions.vue -->
<template>
  <div class="recent-transactions">
    <h3>Recent Transactions</h3>
    <ul>
      <li v-for="transaction in transactions" :key="transaction.id">
        <span>{{ transaction.name }}</span>
        <span>{{ transaction.date }}</span>
        <span
          :class="{
            income: transaction.amount > 0,
            expense: transaction.amount < 0,
          }"
        >
          {{ transaction.amount > 0 ? "+" : "" }}{{ transaction.amount }}
        </span>
      </li>
    </ul>
  </div>
</template>

<script setup>
import { ref } from "vue";

const transactions = ref([
  { id: 1, name: "Transaction 1", date: "2024-03-13", amount: -10000.0 },
  { id: 2, name: "Transaction 2", date: "2024-03-14", amount: 10000.0 },
  // Add more transactions as needed
]);
</script>

<style scoped>
.recent-transactions {
  background: #ffffff;
  padding: 1rem;
  border-radius: 10px;
  margin-top: 2rem;
}
ul {
  list-style: none;
  padding: 0;
}
li {
  display: flex;
  justify-content: space-between;
  padding: 0.5rem 0;
}
.income {
  color: green;
}
.expense {
  color: red;
}
</style>
