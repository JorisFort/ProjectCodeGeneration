<template>
  <div class="accounts-page">
    <h1>Accounts</h1>
    <div class="account-section" v-for="account in accounts" :key="account.id">
      <div class="account-header">
        <h2>{{ account.name }}</h2>
        <p>Balance: {{ account.balance }}</p>
      </div>
      <div class="transactions-section">
        <h3>Transactions</h3>
        <ul>
          <li v-for="transaction in account.transactions" :key="transaction.id">
            <span>{{ transaction.date }}: {{ transaction.description }}</span>
            <span>{{ transaction.amount }}</span>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";

const accounts = ref([
  {
    id: 1,
    name: "Checking",
    balance: "$2,500.00",
    transactions: [
      {
        id: 1,
        date: "2023-05-01",
        description: "Grocery Store",
        amount: "-$50.00",
      },
      {
        id: 2,
        date: "2023-05-03",
        description: "Gas Station",
        amount: "-$30.00",
      },
      // Add more transactions here
    ],
  },
  {
    id: 2,
    name: "Savings",
    balance: "$10,000.00",
    transactions: [
      {
        id: 1,
        date: "2023-05-01",
        description: "Transfer from Checking",
        amount: "+$500.00",
      },
      { id: 2, date: "2023-05-03", description: "Interest", amount: "+$5.00" },
      // Add more transactions here
    ],
  },
]);
</script>

<style scoped>
.accounts-page {
  max-width: 800px;
  margin: 0 auto;
  padding: 2rem;
  background: #f7f9fc;
}

.account-section {
  background: #ffffff;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
  margin-bottom: 2rem;
  padding: 1rem;
}

.account-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  border-bottom: 1px solid #ccc;
  padding-bottom: 0.5rem;
}

.transactions-section {
  margin-top: 1rem;
}

.transactions-section h3 {
  margin-bottom: 0.5rem;
}

.transactions-section ul {
  list-style-type: none;
  padding: 0;
}

.transactions-section li {
  display: flex;
  justify-content: space-between;
  padding: 0.5rem 0;
  border-bottom: 1px solid #eee;
}

.transactions-section li span {
  display: inline-block;
  min-width: 150px;
}
</style>
