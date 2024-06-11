<script setup>
import { ref, computed } from 'vue';
import EmployeeTransactionsTable from "../../common/EmployeeTransactionsTable.vue";
import { getAllTransactions } from "@/services/TransactionService.js";

let transactions = [
  {
    from: "user1",
    to: "user2",
    initiating: "user1",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "user1",
    to: "user2",
    initiating: "user1",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "user1",
    to: "user2",
    initiating: "user1",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "kim",
    to: "aryan",
    initiating: "user1",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "alice",
    to: "bob",
    initiating: "alice",
    dateTime: '2023-01-15T10:30:00',
    amount: 1500
  },
  {
    from: "charlie",
    to: "dave",
    initiating: "charlie",
    dateTime: '2023-02-20T14:45:00',
    amount: 2000
  },
  {
    from: "eve",
    to: "frank",
    initiating: "eve",
    dateTime: '2023-03-10T09:15:00',
    amount: 2500
  },
  {
    from: "george",
    to: "harry",
    initiating: "george",
    dateTime: '2023-04-05T16:30:00',
    amount: 3000
  },
  {
    from: "ivy",
    to: "jack",
    initiating: "ivy",
    dateTime: '2023-05-12T11:00:00',
    amount: 3500
  }
]

const searchQuery = ref('');

const filteredTransactions = computed(() => {
  return transactions.filter(transaction => {
    return Object.values(transaction).some(value =>
    value.toString().toLowerCase().includes(searchQuery.value.toLowerCase())
    );
  });
});

const sortedTransactions = computed(() => {
  return filteredTransactions.value.sort((a, b) => new Date(b.dateTime) - new Date(a.dateTime));
});

const resultsAvailable = computed(() => {
  return sortedTransactions.value.length > 0;
});

</script>

<template>
  <input v-model="searchQuery" type="text" placeholder="Search transactions"/>

  <EmployeeTransactionsTable v-if="resultsAvailable" :transactions="filteredTransactions" />
  <div v-else>No results found</div>
</template>
