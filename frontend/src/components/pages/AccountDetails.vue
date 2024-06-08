<template>
  <div class="account-details">
    <Sidebar />
    <div class="main-content">
      <div class="left-section">
        <UserProfile />
      </div>
      <div class="right-section">
        <AccountBalanceUser />
        <RecentTransactions />
      </div>
    </div>
  </div>
</template>

<script setup>
//import Sidebar from "../Sidebar.vue";
import UserProfile from "../UserProfile.vue";
import AccountBalanceUser from "../AccountBalanceUser.vue";
import RecentTransactions from "../RecentTransactions.vue";
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
