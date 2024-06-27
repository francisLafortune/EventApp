export function format(timestamp) {
    const options = {
        year: 'numeric',
        month: 'long',
        day: 'numeric',
        hour: '2-digit',
        minute: '2-digit'
    };
    return new Date(timestamp * 1000).toLocaleTimeString("fr-FR", options)
}