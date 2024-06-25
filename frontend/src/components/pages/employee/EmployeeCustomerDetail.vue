<script setup>
import EmployeeCustomerDetailOverview from "../../containers/employeeDashboard/EmployeeCustomerDetailOverview.vue";

import {useRoute} from "vue-router";
import {ref} from "vue";

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
      <router-link class="backButton" to="/EmployeeCustomers">
        <button>Back</button>
      </router-link>
    </div>
    <div>
      <EmployeeCustomerDetailOverview :id="id"/>
    </div>
    <div class="grid">
      <router-link :to="{ name: 'EmployeeCustomerTransactions', params: { id: id }}">
        <button class="employeeButton">View all Transactions</button>
      </router-link>
      <router-link :to="{ name: 'EmployeeCustomerChangeDetail', params: { id: id }}">
        <button class="employeeButton">Change details</button>
      </router-link>
      <button class="employeeButton" @click="confirmingDeletion">Close account</button>
    </div>
  </div>

  <div v-if="confirmDeletion">
    <h3>Are you sure you want to close this account?</h3>
    <button class="employeeDeletionButton" @click="deleteAccount">Yes</button>
    <button class="employeeDeletionButton" @click="noDeletion">No</button>
  </div>
</template>