<template>
  <aside>
    <nav>
      <ul>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeDashboard">Overview</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeTransactions">Transactions</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeCustomers">Customers</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeTransfer">Transfer</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeCreateAccount">Create account</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeSignups">Sign ups</RouterLink>
        </li>
        <li class="nav-item">
          <RouterLink class="nav-link" to="/EmployeeAccount">Account</RouterLink>
        </li>
      </ul>
    </nav>
  </aside>

</template>

<script>
export default {
  name: "EmployeeNavigation",
};
</script>
