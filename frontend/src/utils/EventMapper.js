function dateToSecondFromEpoch(date) {
    return date.getTime() / 1000;
}

export function map(eventForm) {
    return {
        name: eventForm.name,
        description: eventForm.description,
        beginTimestamp: eventForm.beginTime !== '' ? dateToSecondFromEpoch(new Date(eventForm.beginTime)) : '',
        endTimestamp: eventForm.endTime !== '' ? dateToSecondFromEpoch(new Date(eventForm.endTime)) : ''
    }
}