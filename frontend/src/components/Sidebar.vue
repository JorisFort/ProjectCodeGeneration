<template>
  <aside class="sidebar">
    <div class="sidebar-content">
      <h2>Bank</h2>
      <nav>
        <router-link to="/dashboard/overview">Overview</router-link>
        <router-link to="/dashboard/accounts">Accounts</router-link>
        <router-link to="/dashboard/transactions">Transactions</router-link>
        <router-link to="/dashboard/profile">Profile</router-link>
      </nav>
      <div class="logout">
        <router-link to="/logout">Logout</router-link>
      </div>
    </div>
  </aside>
</template>

<style scoped>
.sidebar {
  width: 200px;
  background: #f7f9fc;
  padding: 1rem;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}
h2 {
  font-size: 1.5rem;
  margin-bottom: 1rem;
}
nav {
  display: flex;
  flex-direction: column;
}
nav a {
  margin-bottom: 1rem;
  color: #333;
  text-decoration: none;
}
.logout {
  margin-top: auto;
}
.logout a {
  color: #333;
  text-decoration: none;
}
</style>
