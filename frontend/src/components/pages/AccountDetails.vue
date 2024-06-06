<!-- src/components/pages/AccountDetails.vue -->
<template>
  <div class="account-details">
    <Sidebar />
    <div class="main-content">
      <header class="header">
        <h1>Profile</h1>
        <div class="user-info">
          <span class="username">John Doe</span>
          <span class="account-number">1234567890</span>
        </div>
      </header>
      <UserProfile />
      <AccountBalanceUser />
      <RecentTransactions />
    </div>
  </div>
</template>

<script setup>
import Sidebar from "../Sidebar.vue";
import UserProfile from "../UserProfile.vue";
import AccountBalanceUser from "../AccountBalanceUser.vue";
import RecentTransactions from "../RecentTransactions.vue"; // Ensure this path is correct
</script>

<style scoped>
.account-details {
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
</style>
