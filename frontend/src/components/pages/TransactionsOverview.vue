<template>
  <div class="transactions-overview">
    <!-- Removed Sidebar -->
    <div class="main-content">
      <header class="header">
        <h1>Checking Account Transactions</h1>
        <div class="user-info">
          <span class="username">John Doe</span>
          <span class="account-number">1234567890</span>
        </div>
      </header>
      <div class="account-details">
        <h2>Account Balance: $44,500.00</h2>
        <p><strong>IBAN:</strong> GB29NWBK60161331926819</p>
      </div>
      <!-- <TransactionCards /> -->
      <TransactionList />
    </div>
  </div>
</template>

<script setup>
import TransactionCards from "../containers/dashboard/transaction/TransactionCards.vue";
import TransactionList from "../containers/dashboard/transaction/TransactionList.vue";
</script>

<style scoped>
.transactions-overview {
  display: flex;
  flex-direction: column; /* Changed to column to make it longer */
}
.main-content {
  flex: 1;
  padding: 2rem;
  background: #f7f9fc;
  width: 100%; /* Ensure full width */
}
.header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 2rem;
}
.account-details {
  background: #ffffff;
  padding: 2rem;
  border-radius: 10px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
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
