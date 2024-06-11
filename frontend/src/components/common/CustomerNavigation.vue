<template>
  <aside class="sidebar">
    <div class="sidebar-content">
      <h2>Bank</h2>
      <nav>
        <router-link class="nav-link" to="/customerDashboard">
          Overview
        </router-link>
        <router-link class="nav-link" to="/customerAccounts">
          Accounts
        </router-link>
        <!-- <router-link to="/dashboard/transactions" class="nav-link"
          >Transactions</router-link
        > -->
        <router-link class="nav-link" to="/customerProfile">
          Profile
        </router-link>
        <router-link class="nav-link" to="/transfer-funds">
          Transfer Funds
        </router-link>
        <router-link class="nav-link" to="/transfer-between-accounts">
          Transfer Between Accounts
        </router-link>
      </nav>
      <div class="logout">
        <router-link class="nav-link" to="/logout">Logout</router-link>
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

.nav-link {
  margin-bottom: 1rem;
  color: #333;
  text-decoration: none;
  padding: 0.5rem;
  border-radius: 4px;
  transition: color 0.3s, background-color 0.3s;
}

.nav-link:hover {
  color: #007bff;
  background-color: #e1effe;
}

.router-link-active {
  background-color: #d0e0fc;
  color: #0056b3;
}

.logout {
  margin-top: auto;
}

.logout .nav-link {
  color: #333;
  text-decoration: none;
}

.logout .nav-link:hover {
  color: #ff0000;
  background-color: transparent;
}
</style>
