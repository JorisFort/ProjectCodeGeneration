export function formatTimestamp(dateTime) {
    const date = new Date(dateTime);
    return date.toLocaleDateString('en-US', {
        day: 'numeric',
        month: 'numeric',
        year: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
        hour12: false
    });
}