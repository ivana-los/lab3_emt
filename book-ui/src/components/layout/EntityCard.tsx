import { Box, Typography, IconButton } from '@mui/material';
import { useNavigate } from 'react-router';
import EditIcon from '@mui/icons-material/Edit';
import DeleteIcon from '@mui/icons-material/Delete';
import React from 'react';

interface Field {
    label: string;
    value: string | number;
    chip?: boolean;
}

interface Props {
    title: string;
    fields: Field[];
    navigateTo: string;
    accentColor?: string;
    onEdit?: () => void;
    onDelete?: () => void;
    extraActions?: React.ReactNode;
}

const EntityCard = ({ title, fields, navigateTo, accentColor = '#185FA5', onEdit, onDelete, extraActions }: Props) => {
    const navigate = useNavigate();

    return (
        <Box
            onClick={() => navigate(navigateTo)}
            sx={{
                background: 'background.paper',
                border: '0.5px solid',
                borderColor: 'divider',
                borderRadius: '12px',
                overflow: 'hidden',
                cursor: 'pointer',
                height: '100%',
                display: 'flex',
                flexDirection: 'column',
                transition: 'transform 0.2s ease, border-color 0.2s ease',
                '&:hover': {
                    transform: 'translateY(-3px)',
                    borderColor: 'text.disabled',
                },
            }}
        >
            <Box sx={{ height: '3px', width: '100%', bgcolor: accentColor, flexShrink: 0 }} />

            <Box sx={{ p: '16px', flex: 1 }}>
                <Typography
                    noWrap
                    sx={{
                        fontSize: '15px',
                        fontWeight: 600,
                        letterSpacing: '-0.01em',
                        color: 'text.primary',
                        mb: '14px',
                    }}
                >
                    {title}
                </Typography>

                <Box sx={{ display: 'flex', flexDirection: 'column', gap: '8px', bgcolor: 'background.paper' }}>
                    {fields.map((field) => (
                        <Box key={field.label} sx={{ display: 'flex', alignItems: 'center', gap: '8px' }}>
                            <Typography
                                sx={{
                                    fontSize: '11px',
                                    fontWeight: 500,
                                    letterSpacing: '0.04em',
                                    textTransform: 'uppercase',
                                    color: 'text.disabled',
                                    minWidth: '72px',
                                    flexShrink: 0,
                                }}
                            >
                                {field.label}
                            </Typography>

                            {field.chip ? (
                                <Box
                                    component="span"
                                    sx={{
                                        fontSize: '11px',
                                        fontWeight: 500,
                                        px: '8px',
                                        py: '2px',
                                        borderRadius: '4px',
                                        border: '0.5px solid white',
                                        borderColor: 'divider',
                                        color: 'text.secondary',
                                        bgcolor: 'action.hover',
                                    }}
                                >
                                    {field.value}
                                </Box>
                            ) : (
                                <Typography
                                    sx={{
                                        fontSize: '13px',
                                        fontFamily: '"DM Mono", "Roboto Mono", monospace',
                                        color: 'text.primary',
                                    }}
                                >
                                    {field.value}
                                </Typography>
                            )}
                        </Box>
                    ))}
                </Box>
            </Box>

            <Box
                sx={{
                    borderTop: '0.5px solid',
                    borderColor: 'divider',
                    px: '16px',
                    py: '10px',
                    display: 'flex',
                    justifyContent: 'space-between',
                    alignItems: 'center',
                }}
            >
                <Box onClick={(e) => e.stopPropagation()} sx={{ display: 'flex', gap: '4px' }}>
                    {extraActions}
                    {onEdit && (
                        <IconButton size="small" onClick={onEdit}>
                            <EditIcon fontSize="small" />
                        </IconButton>
                    )}
                    {onDelete && (
                        <IconButton size="small" onClick={onDelete} color="error">
                            <DeleteIcon fontSize="small" />
                        </IconButton>
                    )}
                </Box>
                <Typography sx={{ fontSize: '12px', color: 'text.disabled' }}>→</Typography>
            </Box>
        </Box>
    );
};

export default EntityCard;