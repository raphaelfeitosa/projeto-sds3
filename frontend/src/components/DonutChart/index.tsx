import Chart from "react-apexcharts";
import axios from 'axios';
import { Base_URL } from "utils/requests";
import { SaleSum } from "types/sale";

type chartData = {
    labels: string[];
    series: number[];
}

const DonutChart = () => {

    //Forma errada
    let chartData: chartData = { labels: [], series: [] };


    axios.get(`${Base_URL}/sales/amount-by-seller`)
        .then(response => {

            const data = response.data as SaleSum[];
            const myLabels = data.map(labels => labels.sellerName);
            const mySeries = data.map(series => series.sum);

            chartData = { labels: myLabels, series: mySeries };

            console.log(chartData);
        });
    // const mockData = {
    //     series: [477138, 499928, 444867, 220426, 473088],
    //     labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
    // }

    const options = {
        legend: {
            show: true
        }
    }

    return (
        <Chart
            options={{ ...options, labels: chartData.labels }}
            series={chartData.series}
            type="donut"
            height="240"
        />
    );
}

export default DonutChart;