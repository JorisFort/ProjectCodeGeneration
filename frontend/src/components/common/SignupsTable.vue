<script setup>
import { formatTimestamp } from "./helpers.js";

defineProps({
  signups: Array,
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
    <tr v-for="signup in signups">
      <td>{{ signup.firstName }}</td>
      <td>{{ signup.lastName }}</td>
      <td>{{ signup.bsn }}</td>
      <td>{{ signup.email }}</td>
      <td>{{ formatTimestamp(signup.dateRegistered) }}</td>
      <td><button>Approve</button></td>
    </tr>
    </tbody>
  </table>

</template>