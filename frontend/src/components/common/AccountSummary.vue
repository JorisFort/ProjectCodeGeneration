<template>
  <div class="account-summary">
    <h3>Accounts</h3>
    <div class="account-item">
      <span>Checking</span>
      <h2>$44,500.00</h2>
    </div>
    <div class="account-item">
      <span>Savings</span>
      <h2>$44,500.00</h2>
    </div>
  </div>
</template>

<style scoped>
.account-summary {
  display: flex;
  justify-content: space-between;
  margin-bottom: 1rem;
}

.account-item {
  background: #e0f7fa;
  padding: 1rem;
  border-radius: 10px;
  flex: 1;
  margin: 0 0.5rem;
  text-align: center;
}

.account-item:first-child {
  margin-left: 0;
}

.account-item:last-child {
  margin-right: 0;
}

h3 {
  margin-bottom: 1rem;
}

h2 {
  margin: 0;
  font-size: 1.5rem;
}

span {
  display: block;
  margin-bottom: 0.5rem;
}
</style>
