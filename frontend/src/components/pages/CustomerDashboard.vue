<template>
  <div class="dashboard">
    <Sidebar />
    <div class="main-content">
      <header class="header">
        <h1>Overview</h1>
        <div class="user-info">
          <span class="username">John Doe</span>
          <span class="account-number">1234567890</span>
        </div>
      </header>
      <div class="content">
        <AccountBalance />
        <AccountSummary />
        <Statistics />
      </div>
    </div>
  </div>
</template>

<script setup>
//import Sidebar from "../CustomerNavigation.vue";
import AccountBalance from "../common/AccountBalance.vue";
import AccountSummary from "../common/AccountSummary.vue";
import Statistics from "../containers/Statistics.vue";
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
