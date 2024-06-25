<template>
  <div class="account-details">
    <Sidebar/>
    <div class="main-content">
      <div class="left-section">
        <UserProfile v-if="state.customer" :customer="state.customer"/>
      </div>
    </div>
  </div>
</template>

<script setup>
import Sidebar from "../../common/CustomerNavigation.vue";
import UserProfile from "../../containers/customerDashboard/UserProfile.vue";
import {getCustomer} from "@/services/CustomerService.js";
import {onMounted, reactive} from "vue";

const state = reactive({
  customer: null,
});

onMounted(async () => {
  const user = JSON.parse(localStorage.getItem('user'));
  state.customer = await getCustomer(user.id);
});
</script>

<style scoped>
.account-details {
  display: flex;
}

.main-content {
  flex: 1;
  display: flex;
  padding: 2rem;
  background: #f7f9fc;
}

.left-section {
  flex: 1.5; /* Increase the flex ratio to make it wider */
  max-width: 400px; /* Increase max-width for more width */
  padding-right: 2rem; /* Keeps some spacing between the sections */
}

.right-section {
  flex: 2;
  display: flex;
  flex-direction: column;
}
</style>
