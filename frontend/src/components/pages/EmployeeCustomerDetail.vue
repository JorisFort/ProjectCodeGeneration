<script setup>
import EmployeeCustomerDetailOverview from "../containers/dashboard/EmployeeCustomerDetailOverview.vue";

import {useRoute} from "vue-router";
import {computed, ref} from "vue";
const id = useRoute().params.id;

const confirmDeletion = ref(false);

const confirmingDeletion = () => {
  confirmDeletion.value = true;
};

const noDeletion = () => {
  confirmDeletion.value = false;
};

const deleteAccount = () => {

};
</script>

<template>
    <div v-if="!confirmDeletion">
      <div>
        <router-link to="/EmployeeCustomers" class="backButton"><button>Back</button></router-link>
      </div>
      <div>
        <EmployeeCustomerDetailOverview :id = "id"/>
      </div>
      <div class="grid">
        <router-link :to="{ name: 'EmployeeCustomerTransactions', params: { id: id }}"><button class="employeeButton">View all Transactions</button></router-link>
        <router-link :to="{ name: 'EmployeeCustomerChangeDetail', params: { id: id }}"><button class="employeeButton">Change details</button></router-link>
        <button @click="confirmingDeletion" class="employeeButton">Close account</button>
      </div>
    </div>

    <div v-if="confirmDeletion">
      <h3>Are you sure you want to close this account?</h3>
      <button @click="deleteAccount" class="employeeDeletionButton">Yes</button>
      <button @click="noDeletion" class="employeeDeletionButton">No</button>
    </div>
</template>