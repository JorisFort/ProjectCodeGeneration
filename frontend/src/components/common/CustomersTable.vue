<script setup>
import { formatTimestamp } from "./helpers.js";

defineProps({
  customers: Array,
});

</script>

<template>

  <table>
    <thead>
    <tr>
      <th scope="col">First name</th>
      <th scope="col">Last name</th>
      <th scope="col">BSN</th>
      <th scope="col">Email</th>
      <th scope="col">Registration date</th>
    </tr>
    </thead>
    <tbody>
    <tr v-for="customer in customers">
      <td>{{ customer.firstName }}</td>
      <td>{{ customer.lastName }}</td>
      <td>{{ customer.bsn }}</td>
      <td>{{ customer.email }}</td>
      <td>{{ formatTimestamp(customer.dateRegistered) }}</td>
    </tr>
    </tbody>
  </table>

</template>
