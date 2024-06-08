<template>
  <aside>
    <h2>Bank</h2>
    <nav>
      <ul>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeDashboard">Overview</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeTransactions">Transactions</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeCustomers">Customers</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeTransfer">Transfer</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeCreateAccount">Create account</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeSignups">Sign ups</router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/EmployeeAccount">Account</router-link>
        </li>
      </ul>
    </nav>
  </aside>
</template>

<style scoped>
nav {
  width: 200px;
  padding: 1rem;
  height: 100vh;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
}

.nav-link {
  margin-bottom: 1rem;
  text-decoration: none;
  padding: 0.5rem;
  border-radius: 4px;
  transition: color 0.3s, background-color 0.3s;
}

.nav-link:hover {
  color: #007bff;
  background-color: #e1effe;
}
</style>
