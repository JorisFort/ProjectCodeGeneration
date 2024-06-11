<template>
  <div class="transaction-list">
    <table>
      <thead>
      <tr>
        <th></th>
        <th>Name</th>
        <th>Type</th>
        <th>Date</th>
        <th>Amount</th>
        <th>Status</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="transaction in transactions" :key="transaction.id">
        <td>
            <span :class="transaction.type === 'Credit' ? 'credit' : 'debit'">
              {{ transaction.type === "Credit" ? "+" : "-" }}
            </span>
        </td>
        <td>{{ transaction.name }}</td>
        <td>{{ transaction.type }}</td>
        <td>{{ transaction.date }}</td>
        <td :class="transaction.type === 'Credit' ? 'credit' : 'debit'">
          {{ transaction.amount }}
        </td>
        <td>
            <span :class="transaction.status.toLowerCase()">
              {{ transaction.status }}
            </span>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import {ref} from "vue";

const transactions = ref([
  {
    id: 1,
    name: "Name",
    type: "Debit",
    date: "13.03.2024 - 09:39",
    amount: "-10,000.00",
    status: "Pending",
  },
  {
    id: 2,
    name: "Name",
    type: "Credit",
    date: "Date",
    amount: "+10,000.00",
    status: "Completed",
  },
  {
    id: 3,
    name: "Name",
    type: "Debit",
    date: "Date",
    amount: "-10,000.00",
    status: "Canceled",
  },
  {
    id: 4,
    name: "Name",
    type: "Credit",
    date: "Date",
    amount: "+10,000.00",
    status: "Completed",
  },
  {
    id: 5,
    name: "Name",
    type: "Debit",
    date: "Date",
    amount: "-10,000.00",
    status: "Pending",
  },
  {
    id: 6,
    name: "Name",
    type: "Credit",
    date: "Date",
    amount: "+10,000.00",
    status: "Completed",
  },
  {
    id: 7,
    name: "Name",
    type: "Debit",
    date: "Date",
    amount: "-10,000.00",
    status: "Canceled",
  },
]);
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

.credit {
  color: #28a745;
}

.debit {
  color: #dc3545;
}

.pending {
  background: #ccc;
  color: #333;
  padding: 0.2rem 0.5rem;
  border-radius: 5px;
}

.completed {
  background: #28a745;
  color: #fff;
  padding: 0.2rem 0.5rem;
  border-radius: 5px;
}

.canceled {
  background: #dc3545;
  color: #fff;
  padding: 0.2rem 0.5rem;
  border-radius: 5px;
}
</style>
