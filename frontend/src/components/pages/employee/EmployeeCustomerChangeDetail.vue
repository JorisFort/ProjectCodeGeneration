<script setup>
import EmployeeCustomerChangeDetailForm from "../../containers/employeeDashboard/EmployeeCustomerChangeDetailForm.vue";
import {useRoute} from "vue-router";

const id = useRoute().params.id;
</script>

<template>
  <div>
    <router-link :to="{ name:'EmployeeCustomerDetail', params: { id: id} }" class="backButton">
      <button>Back</button>
    </router-link>
  </div>
  <div>
    <EmployeeCustomerChangeDetailForm :id="id"/>
  </div>
</template>