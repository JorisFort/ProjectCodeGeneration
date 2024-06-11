<template>
  <div class="statistics">
    <h3>Statistics</h3>
    <div class="stat-item">
      <span>Income</span>
      <div class="progress">
        <div :style="{ width: '80%' }" class="progress-bar income"></div>
      </div>
      <span>$54,500.00</span>
    </div>
    <div class="stat-item">
      <span>Expense</span>
      <div class="progress">
        <div :style="{ width: '20%' }" class="progress-bar expense"></div>
      </div>
      <span>$10,000.00</span>
    </div>
  </div>
</template>

<style scoped>
.statistics {
  background: #e0f7fa;
  padding: 1rem;
  border-radius: 10px;
}

.stat-item {
  margin-bottom: 1rem;
}

.progress {
  background: #f1f1f1;
  border-radius: 10px;
  height: 10px;
  overflow: hidden;
  margin: 0.5rem 0;
}

.progress-bar {
  height: 100%;
  border-radius: 10px;
}

.income {
  background: #28a745;
}

.expense {
  background: #dc3545;
}
</style>
