import React from 'react';
import { Bar, Pie } from 'react-chartjs-2';
import { Chart as ChartJS, CategoryScale, LinearScale, BarElement, ArcElement } from 'chart.js';

// Register necessary components
ChartJS.register(CategoryScale, LinearScale, BarElement, ArcElement);

const GenericGraph = ({ chartType, data, options }) => {
    switch (chartType) {
        case 'bar':
            return <Bar data={data} options={options} />;
        case 'pie':
            return <Pie data={data} options={options} />;
        default:
            return null;
    }
};
export default GenericGraph;