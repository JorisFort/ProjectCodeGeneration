<script setup>
import { formatTimestamp } from "./helpers.js";

defineProps({
  transactions: Array,
});
</script>

<template>
  <table>
    <thead>
    <tr>
      <th scope="col">From</th>
      <th scope="col">To</th>
      <th scope="col">User initiating</th>
      <th scope="col">Time stamp</th>
      <th scope="col">Transfer amount</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="transaction in transactions">
      <td>{{ transaction.from }}</td>
      <td>{{ transaction.to }}</td>
      <td>{{ transaction.initiating }}</td>
      <td>{{ formatTimestamp(transaction.dateTime) }}</td>
      <td>€ {{ transaction.amount }}</td>
    </tr>
    </tbody>
  </table>
</template>
