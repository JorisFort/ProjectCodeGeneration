<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/api-test">API Test</router-link> |
      <router-link to="/login">Login</router-link> |
      <router-link to="/register">Register</router-link> |
      <router-link to="/transfer-funds">Transfer Funds</router-link> |
      <router-link to="/transfer-between-accounts"
        >Transfer Between Accounts</router-link
      >
      | <router-link to="/dashboard/overview">Dashboard</router-link> |
      <router-link to="/dashboard/transactions">Transactions</router-link> |
      <router-link to="/dashboard/account-details">Profile</router-link>
      <!-- Add link to account details -->
    </nav>
    <router-view></router-view>
  </div>
</template>

<script setup></script>

<style scoped>
nav {
  margin-bottom: 1rem;
}
</style>
