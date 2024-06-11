<script setup>
import EmployeeCustomerTransactions from "../containers/dashboard/EmployeeCustomerTransactionsOverview.vue";
import {useRoute} from "vue-router";

const id = useRoute().params.id;
</script>

<template>
  <div>
    <router-link :to="{ name: 'EmployeeCustomerDetail', params: { id: id }}" class="backButton">
      <button>Back</button>
    </router-link>
  </div>
  <div>
    <EmployeeCustomerTransactions :id="id.toString()"/>
  </div>
</template>