<template>
  <div class="dashboard">
    <Sidebar/>
    <div class="main-content">
      <header class="header">
        <h1>Overview</h1>
        <div class="user-info">
          <span class="username">{{ state.name }}</span>
          <span class="account-number">{{ state.id }}</span>
        </div>
      </header>
      <div class="content">
        <AccountBalance/>
        <AccountSummary/>
        <Statistics/>
      </div>
    </div>
  </div>
</template>

<script setup>
import Sidebar from "../../common/CustomerNavigation.vue";
import AccountBalance from "../../common/AccountBalance.vue";
import AccountSummary from "../../common/AccountSummary.vue";
import Statistics from "../../containers/customerDashboard/overview/Statistics.vue";
import {getCustomer} from "@/services/CustomerService.js";
import {reactive} from "vue";
import { onMounted } from 'vue';

const state = reactive({
  name: "",
  id: "",
});

onMounted(async () => {
  const user = JSON.parse(localStorage.getItem('user'));
  const customer = await getCustomer(user.id);

  state.name = customer.firstName + ' ' + customer.lastName;
  state.id = user.id;
});

</script>

<style scoped>
.dashboard {
  display: flex;
}

.main-content {
  flex: 1;
  padding: 2rem;
  background: #f7f9fc;
}

.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}

.user-info {
  text-align: right;
}

.username {
  display: block;
  font-weight: bold;
}

.account-number {
  display: block;
  color: #999;
}

.content {
  display: flex;
  flex-direction: column;
}
</style>
