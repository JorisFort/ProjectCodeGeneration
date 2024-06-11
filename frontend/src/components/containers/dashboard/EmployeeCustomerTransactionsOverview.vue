<script setup>
import { ref, computed } from 'vue';
import EmployeeTransactionsTable from "../../common/EmployeeTransactionsTable.vue";

const props = defineProps( {
  id: String,
});

let transactions = [
  {
    from: "a1b2c3d5", // user1
    to: "e5f6g7h9",   // user2
    initiating: "a1b2c3d5",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "a1b2c3d5", // user1
    to: "e5f6g7h9",   // user2
    initiating: "a1b2c3d5",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "a1b2c3d5", // user1
    to: "e5f6g7h9",   // user2
    initiating: "a1b2c3d5",
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "i1j2k3l4", // kim
    to: "m1n2o3p4",   // aryan
    initiating: "a1b2c3d5", // user1
    dateTime: Date.now(),
    amount: 1000
  },
  {
    from: "a1b2c3d4", // Alice
    to: "e5f6g7h8",   // Bob
    initiating: "a1b2c3d4",
    dateTime: '2023-01-15T10:30:00',
    amount: 1500
  },
  {
    from: "q1r2s3t4", // charlie
    to: "m3n4o5p6",   // Dave
    initiating: "q1r2s3t4",
    dateTime: '2023-02-20T14:45:00',
    amount: 2000
  },
  {
    from: "q7r8s9t0", // Eva
    to: "u1v2w3x4",   // Frank
    initiating: "q7r8s9t0",
    dateTime: '2023-03-10T09:15:00',
    amount: 2500
  },
  {
    from: "u5v6w7x8", // george
    to: "y1z2a3b4",   // harry
    initiating: "u5v6w7x8",
    dateTime: '2023-04-05T16:30:00',
    amount: 3000
  },
  {
    from: "g3h4i5j6", // Ivy
    to: "c1d2e3f4",   // jack
    initiating: "g3h4i5j6",
    dateTime: '2023-05-12T11:00:00',
    amount: 3500
  }
];

const filteredTransactions = computed(() => {
  return transactions.filter(transaction => {
    return Object.values(transaction).some(value =>
        value.toString().includes(props.id)
    );
  });
});

const sortedTransactions = computed(() => {
  return filteredTransactions.value.sort((a, b) => new Date(b.dateTime) - new Date(a.dateTime));
});

</script>

<template>
  <EmployeeTransactionsTable :transactions="sortedTransactions" />
</template>
