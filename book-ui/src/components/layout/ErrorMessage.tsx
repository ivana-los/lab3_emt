import { Alert, Box } from '@mui/material';

interface Props {
    message?: string;
}

const ErrorMessage = ({ message = 'There has been a mistake..' }: Props) => {
    return (
        <Box sx={{ py: 4 }}>
            <Alert severity="error">{message}</Alert>
        </Box>
    );
};

export default ErrorMessage;