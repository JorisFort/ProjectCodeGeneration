<template>
  <div class="transaction-list">
    <table>
      <thead>
      <tr>
        <th></th>
        <th>Type</th>
        <th>Date</th>
        <th>Amount</th>
        <th>Status</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="transaction in transactions" :key="transaction.transactionId">
        <td>
            <span :class="determineTransaction(transaction) === 'deposit' ? 'deposit' : 'withdraw'">
              {{ determineTransaction(transaction) === 'deposit' ? '+' : '-' }}
            </span>
        </td>
        <td>{{ transaction.transactionType }}</td>
        <td>{{ formatDate(transaction.timestamp) }}</td>
        <td :class="determineTransaction(transaction) === 'deposit' ? 'deposit' : 'withdraw'">
          {{ formatAmount(transaction.amount) }}
        </td>
        <td>
            <span class="completed">Completed</span>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { ref, defineProps } from "vue";

const props = defineProps({
  transactions: {
    type: Array,
    required: true,
    default: () => [],
  },
  accountId: {
    type: String,
    required: true,
  },
});

const transactions = ref(props.transactions);
const accountId = Number(props.accountId);

const formatDate = (timestamp) => {
  const date = new Date(timestamp);
  const minutes = date.getMinutes();
  const formattedMinutes = minutes < 10 ? '0' + minutes : minutes;
  return `${date.getDate()}/${date.getMonth()+1}/${date.getFullYear()} - ${date.getHours()}:${formattedMinutes}`;
};
const formatAmount = (amount) => {
  return new Intl.NumberFormat('nl-NL', { style: 'currency', currency: 'EUR' }).format(amount);
};

const determineTransaction = (transaction) => {
  if (transaction.transactionType === 'TRANSFER') {
    if (transaction.fromAccount.accountId === accountId) {
      return 'withdraw';
    } else if (transaction.toAccount.accountId === accountId) {
      return 'deposit';
    }
  } else if (transaction.transactionType === 'DEPOSIT') {
    return 'deposit';
  } else { // Assuming the only other type can be 'WITHDRAW'
    return 'withdraw';
  }
};
</script>

<style scoped>
.transaction-list {
  width: 100%;
  overflow-x: auto;
  margin-top: 1rem;
}

table {
  width: 100%;
  border-collapse: collapse;
}

th,
td {
  padding: 1rem;
  text-align: left;
}

th {
  background: #f7f9fc;
}

tbody tr:nth-child(odd) {
  background: #f7f9fc;
}

.deposit {
  color: #28a745;
}

.withdraw {
  color: #dc3545;
}

.completed {
  background: #28a745;
  color: #fff;
  padding: 0.2rem 0.5rem;
  border-radius: 5px;
}
</style>
