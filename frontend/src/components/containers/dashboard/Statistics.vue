<template>
  <div class="statistics">
    <h3>Statistics</h3>
    <div class="stat-item">
      <span>Income</span>
      <div class="progress">
        <div :style="{ width: state.incomePercentage + '%' }" class="progress-bar income"></div>
      </div>
      <span>€ {{state.income}}</span>
    </div>
    <div class="stat-item">
      <span>Expense</span>
      <div class="progress">
        <div :style="{ width: state.expensePercentage + '%' }" class="progress-bar expense"></div>
      </div>
      <span>€ {{state.expense}}</span>
    </div>
  </div>
</template>

<script setup>
import { onMounted, reactive } from "vue";
import {getAllTransactionByUser} from "@/services/TransactionService.js";

const state = reactive({
  income: 0,
  expense: 0,
  incomePercentage: 0,
  expensePercentage: 0
});

onMounted(async () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const transactions = await getAllTransactionByUser(user.id);

  console.log(transactions)

  state.income = transactions
      .filter(t => t.transactionType === 'DEPOSIT')
      .reduce((sum, t) => sum + t.amount, 0);

  state.expense = transactions
      .filter(t => t.transactionType === 'WITHDRAWAL' || t.transactionType === 'TRANSFER')
      .reduce((sum, t) => sum + t.amount, 0);

  const totalAmount = state.income + state.expense;

  state.incomePercentage = (state.income / totalAmount) * 100;
  state.expensePercentage = (state.expense / totalAmount) * 100;
});
</script>

<style scoped>
.statistics {
  background: #e0f7fa;
  padding: 1rem;
  border-radius: 10px;
}

.stat-item {
  margin-bottom: 1rem;
}

.progress {
  background: #f1f1f1;
  border-radius: 10px;
  height: 10px;
  overflow: hidden;
  margin: 0.5rem 0;
}

.progress-bar {
  height: 100%;
  border-radius: 10px;
}

.income {
  background: #28a745;
}

.expense {
  background: #dc3545;
}
</style>
